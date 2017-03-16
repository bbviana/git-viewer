package br.com.viana

import spock.lang.Shared
import spock.lang.Specification

/**
 * @author bbviana
 */
class RespositoriesAPISpec extends Specification{

    @Shared
    RepositoriesController controller = new RepositoriesController()

    def "branches"(){
        expect:
        println controller.branches("dali")
    }

    def "tags"(){
        expect:
        println controller.tags("dali")
    }
}
