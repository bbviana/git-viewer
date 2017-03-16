package br.com.viana

import groovy.transform.CompileStatic
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * @author bbviana
 */
@RestController
@RequestMapping(path = "/repositories/{name}")
@CompileStatic
class RepositoriesController {

    @RequestMapping(method = GET, path = "/branches")
    List<String> branches(@PathVariable String name) {
        "git -C /home/bbviana/workspace/${name} branch".execute().text.readLines().collect {
            it.replaceAll("\\*", "").trim()
        }
    }

    @RequestMapping(method = GET, path = "/tags")
    List<String> tags(@PathVariable String name) {
        "git -C /home/bbviana/workspace/${name} tag".execute().text.readLines()
    }

    @RequestMapping(method = GET, path = "/ls-files/{object}")
    List<File> lsFiles(@PathVariable String name, @PathVariable String object) {
        "git -C /home/bbviana/workspace/${name} ls-tree ${object}".execute().text.readLines().collect {
            String[] parts = it.split("\t")
            String[] info = parts[0].split("\\s")
            String fileName = parts[1]
            new File(
                    type: FileType.fromGitType(info[1]),
                    objectId: info[2],
                    name: fileName.trim()
            )
        }
    }
}
