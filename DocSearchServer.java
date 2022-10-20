import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class FileHelpers {
    static List<File> getFiles(Path start) throws IOException {
        File f = start.toFile();
        List<File> result = new ArrayList<>();
        if(f.isDirectory()) {
            System.out.println("It's a folder");
            File[] paths = f.listFiles();
            for(File subFile: paths) {
                result.addAll(getFiles(subFile.toPath()));
            }
        }
        else {
            result.add(start.toFile());
        }
        return result;
    }
    static String readFile(File f) throws IOException {
        System.out.println(f.toString());
        return new String(Files.readAllBytes(f.toPath()));
    }
}

class Handler implements URLHandler {
    List<File> files;
    private static Map<String, Function<URI, String>> HANDLERS = new HashMap<>();

    Handler(String directory) throws IOException {
      this.files = FileHelpers.getFiles(Paths.get(directory));
        HANDLERS.put("/", url -> "There are " + this.files.size() + " files to search");
        HANDLERS.put("/search", url -> {
            String[] rawQuery = url.getQuery().split("=");
            String query = null;
            if (rawQuery.length == 2 && rawQuery[0].equalsIgnoreCase("q")) {
                query = rawQuery[1];
            }

            if (query == null) return "Please enter a valid search query!";

            String finalQuery = query;
            List<File> found = this.files.stream().filter(file -> {
                try {
                    return FileHelpers.readFile(file).toLowerCase(Locale.ROOT).contains(finalQuery.toLowerCase(Locale.ROOT));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());

            return "There are " + found.size() + " files found: " + found.stream().map(File::getPath).collect(Collectors.joining(", "));
        });
    }
    public String handleRequest(URI url) throws IOException {
        String path = url.getPath();

        Function<URI, String> handler = HANDLERS.get(path.toLowerCase());
        if (handler != null) return handler.apply(url);

        return "404 Not Found!";
    }
}

class DocSearchServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler("./technical/"));
    }
}

