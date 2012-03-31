package hanamegane

/**
 * Created by IntelliJ IDEA.
 * User: m_arino
 * Date: 12/03/31
 * Time: 20:11
 * To change this template use File | Settings | File Templates.
 */
class VendingMacine {

    def money = 0

    private static final List illegalMoneys = [ 1, 5 ];
    
    def getMoney() {
        money
    }

    def insert( value ) {
        
        if( illegalMoneys.findAll { it == value } ) {
            throw new IllegalArgumentException()
        }
        money += value
    }
}
