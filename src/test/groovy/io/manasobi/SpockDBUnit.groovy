package io.manasobi

import org.flywaydb.test.annotation.FlywayTest
import spock.lang.Specification

/**
 * Created by twjang on 15. 9. 3.
 */
class SpockDBUnit extends Specification {

    @FlywayTest()
    def setupSpec() {
        println('start')
    }

    def test1() {
        when:
            println('123')

        then:
            println('1234')

    }


}
