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

    def "ls-files"(){
        expect:
        println controller.lsFiles("dali", "master").each { println it}
    }

}
