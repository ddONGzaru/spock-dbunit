package io.manasobi

import io.manasobi.config.DataSourceConfig
import io.manasobi.config.TestConfig
import org.flywaydb.test.annotation.FlywayTest
import org.flywaydb.test.dbunit.DBUnitSupport
import org.flywaydb.test.dbunit.FlywayDBUnitTestExecutionListener
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import spock.lang.Specification

/**
 * Created by twjang on 15. 9. 3.
 */
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = TestConfig.class)
@TestExecutionListeners([DependencyInjectionTestExecutionListener.class,
    FlywayDBUnitTestExecutionListener.class])
@FlywayTest
class SpockDBUnit extends Specification {

    def setup() {
        println('start')
    }

    @DBUnitSupport(loadFilesForRun = ["INSERT", "/dataset/person.xml"])
    def test1() {
        when:
            println('test-1')

        then:
            println('test-1')

    }

    @DBUnitSupport(loadFilesForRun = ["INSERT", "/dataset/person2.xml"])
    def test2() {
        when:
        println('test-2')

        then:
        println('test-2')

    }


}
