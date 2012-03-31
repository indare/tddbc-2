package hanamegane
import spock.lang.Specification
/**
 * Created by IntelliJ IDEA.
 * User: m_arino
 * Date: 12/03/31
 * Time: 20:12
 * To change this template use File | Settings | File Templates.
 */
class VendingMacineTest extends Specification {

    VendingMacine vm

    def setup () {
        vm = new VendingMacine()
    }

    def "合計金額が取れる" () {
        expect:
        vm.getMoney() == 0
    }
    
    def "使えるお金を入れる" () {
        when:
        vm.insert( cash )

        then:
        vm.getMoney() == result

        where:
        cash | result
        1000 | 1000
        500  | 500
        100  | 100
        50   | 50
        10   | 10
    }

    def "使えないお金をいれる" () {
        when:
        vm.insert( cash )

        then:
        thrown(IllegalArgumentException)
        vm.getMoney() == result

        where:
        cash | result
        5    | 0
        1    | 0
    }
    
    def "対応しているお金をいれると1660円になる"() {
        when:
        vm.insert(cash1)
        vm.insert(cash2)
        then:
        vm.getMoney() == result
        where:
        cash1 | cash2 | result
        1000  | 500   | 1500
    }
    
}
