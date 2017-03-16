package br.com.viana

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * @author bbviana
 */
@RestController
@RequestMapping(path = "/repositories/{name}")
class RepositoriesController {

    @RequestMapping(method = GET, path = "/branches")
    List<String> branches(@PathVariable String name) {
        return "git -C /home/bbviana/workspace/${name} branch".execute().text.readLines().collect{
            return it.replaceAll("\\*", "").trim()
        }
    }

    @RequestMapping(method = GET, path = "/tags")
    List<String> tags(@PathVariable String name) {
        return "git -C /home/bbviana/workspace/${name} tag".execute().text.readLines()
    }
}
