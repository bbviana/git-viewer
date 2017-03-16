package br.com.viana

/**
 * @author bbviana
 */
enum FileType {
    FILE,
    DIRECTORY,
    UNKNOWN

    static FileType fromGitType(String gitType) {
        if (gitType == "blob") {
            return FILE
        }

        if (gitType == "tree") {
            return DIRECTORY
        }

        return UNKNOWN
    }
}
