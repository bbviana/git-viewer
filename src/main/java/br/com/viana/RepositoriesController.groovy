package br.com.viana

import groovy.transform.CompileStatic
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.nio.file.Path

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * @author bbviana
 */
@RestController
@RequestMapping(path = "/repositories/{repository}")
@CompileStatic
class RepositoriesController {

    @RequestMapping(method = GET, path = "/branches")
    List<String> branches(@PathVariable String repository) {
        "git -C /home/bbviana/workspace/${repository} branch".execute().text.readLines().collect {
            it.replaceAll("\\*", "").trim()
        }
    }

    @RequestMapping(method = GET, path = "/tags")
    List<String> tags(@PathVariable String repository) {
        "git -C /home/bbviana/workspace/${repository} tag".execute().text.readLines()
    }

    @RequestMapping(method = GET, path = "/tree/{object}")
    List<File> tree(@PathVariable String repository,
                    @PathVariable String object) {
        "git -C /home/bbviana/workspace/${repository} ls-tree ${object}".execute().text.readLines().collect {
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

    @RequestMapping(method = GET, path = "/tree/{object}")
    File blob(@PathVariable String repository,
                @PathVariable String object) {
        null
    }

    @RequestMapping(method = GET, path = "/commits/{branch}")
    List<Commit> commits(@PathVariable String repository,
                         @PathVariable String branch) {
        []
    }

    @RequestMapping(method = GET, path = "/commit/{object}")
    List<CommitLog> log(@PathVariable String repository,
                        @PathVariable String object){
        []
    }

    // COUNT

    @RequestMapping(method = GET, path = "/branches-count/{branch}")
    int branchesCount(@PathVariable String repository,
                      @PathVariable String branch) {
        0
    }

    @RequestMapping(method = GET, path = "/tags-count/{branch}")
    int tagsCount(@PathVariable String repository,
                  @PathVariable String branch) {
        0
    }

    @RequestMapping(method = GET, path = "/commits-count/{branch}")
    int commitsCount(@PathVariable String repository,
                     @PathVariable String branch) {
        0
    }

    @RequestMapping(method = GET, path = "/contributors-count/{branch}")
    int contributorsCount(@PathVariable String repository,
                          @PathVariable String branch) {
        0
    }
}
