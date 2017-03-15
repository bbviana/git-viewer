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
        return []
    }

    @RequestMapping(method = GET, path = "/tags")
    List<String> tags(@PathVariable String name) {
        return []
    }
}
