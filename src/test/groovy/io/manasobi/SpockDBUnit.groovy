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
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = DataSourceConfig.class)
//@ContextConfiguration(loader = SpringApplicationContextLoader.class)
@TestExecutionListeners([ DependencyInjectionTestExecutionListener.class,
    FlywayDBUnitTestExecutionListener.class ])
class SpockDBUnit extends Specification {

    @FlywayTest()
    def setup() {
        println('start')
    }

    @DBUnitSupport(loadFilesForRun = ["INSERT", "/dataset/dbunit.xml"])
    def test1() {
        when:
            println('123')

        then:
            println('1234')

    }


}
