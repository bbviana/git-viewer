package br.com.viana

import groovy.transform.CompileStatic
import groovy.transform.ToString

/**
 * @author bbviana
 */
@ToString
@CompileStatic
class File {

    FileType type

    String name

    String objectId

    String content
}
