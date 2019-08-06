package collections.javaio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.List;
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

        DosFileAttributes dosFileAttributes = Files.readAttributes(path,DosFileAttributes.class);
        System.out.println(" " + dosFileAttributes.creationTime());

        /*Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rwx------");
        FileAttribute<Set<PosixFilePermission>> setFileAttribute = PosixFilePermissions.asFileAttribute(posixFilePermissions);
        Files.createFile(Paths.get("first.txt"), setFileAttribute)static;
*/
        UserPrincipal user = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("vadym");
        AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
        AclEntry aclEntry = AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(user).setPermissions(AclEntryPermission.READ_ATTRIBUTES, AclEntryPermission.READ_DATA)
                .build();
        List<AclEntry> acl = view.getAcl();
        acl.add(aclEntry);
        view.setAcl(acl);
    }
    public static void validateView(FileStore fs, Class <? extends FileAttributeView> viewClass){
        boolean supports = fs.supportsFileAttributeView(viewClass);

        System.out.println("Supports "+viewClass.getSimpleName() + " - " + supports);
    }
}
