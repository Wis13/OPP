package collections.javaio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Set;

public class FileAttributor  {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("temp");
        System.out.println("Size " + Files.size(path));
        System.out.println("Date modified " + Files.getLastModifiedTime(path) );
        System.out.println("Is writable " + Files.isWritable(path) );

        FileStore fs = Files.getFileStore(path);

        validateView(fs,BasicFileAttributeView.class);
        validateView(fs,DosFileAttributeView.class);
        validateView(fs,PosixFileAttributeView.class);
        validateView(fs,AclFileAttributeView.class);
        validateView(fs,UserDefinedFileAttributeView.class);
        validateView(fs,FileOwnerAttributeView.class);

        Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rwx------");

    }
    public static void validateView(FileStore fs, Class <? extends FileAttributeView> viewClass){
        boolean supports = fs.supportsFileAttributeView(viewClass);

        System.out.println("Supports "+viewClass.getSimpleName() + " - " + supports);
    }
}
