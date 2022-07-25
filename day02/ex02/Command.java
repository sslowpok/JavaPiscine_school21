package ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Command {

    private Path currentDirectory;

    public Command(Path currentDirectory) {
        setCurrentDirectory(currentDirectory);
    }

    public void setCurrentDirectory(Path currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public Path getCurrentDirectory() {
        return this.currentDirectory;
    }

    public void ls() throws RuntimeException {

        try (Stream<Path> streamSubPaths = Files.walk(currentDirectory, 1)) {
            List<Path> listSubPaths = streamSubPaths.collect(Collectors.toList());

            for (Path path : listSubPaths) {
                if (!path.getFileName().toString().startsWith(".") && !path.equals(currentDirectory)) {
                    System.out.println(path.getFileName() + " " + (Files.size(path) / 1024 + "KB"));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    void mv(String from, String to) throws IOException {

        Path srcPath = Paths.get(from);
        Path toPath = Paths.get(to);

        Path tmpSrc = Paths.get(this.getCurrentDirectory() + "/" + srcPath).normalize();
        Path tmpDir = Paths.get(this.getCurrentDirectory() + "/" + toPath).normalize();

        if (Files.isRegularFile(tmpSrc)) {
            if (Files.isDirectory(tmpDir))
                tmpDir = Paths.get(tmpDir + "/" + tmpSrc.getFileName());
            Files.move(tmpSrc, tmpDir, REPLACE_EXISTING);
        }
        else
            System.out.println("Wrong source file path");
    }

    void cd(Path path) {

        Path absolutePath = Paths.get(getCurrentDirectory().toString() + "/" + path.toString());

        if (Files.exists(absolutePath) && Files.isDirectory(absolutePath)) {
            setCurrentDirectory(absolutePath.normalize());
            System.out.println(getCurrentDirectory().toString());
        } else {
            System.out.println("No such directory");
        }

    }

}
