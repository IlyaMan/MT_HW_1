import jade.core.AID
import jade.core.behaviours.SimpleBehaviour
import jade.lang.acl.ACLMessage
import kotlin.random.Random

class MTAgentBehaviour(
    private val agent: MTAgent,
    private var number: Double,
    private val nodesNum: Int,
    private val connectedAgents: List<AID>
) : SimpleBehaviour() {
    private var state: Int = 0
    private val alpha: Double = 1.0 / nodesNum.toDouble()
    private val name = agent.name.split("@")[0]

    override fun action() {
//      Send collected numbers to all neighbours
        for (connectedAgent in connectedAgents) {
            val msg = ACLMessage(ACLMessage.INFORM)
            msg.content = this.number.toString()
            msg.addReceiver(connectedAgent)
            agent.send(msg)
        }

//      Receive collected numbers from all neighbours
        var sum: Double = 0.0
        for (i in 1..connectedAgents.size) {
            val receivedMessage = agent.blockingReceive()
//          Chance to lose message
            if (Random.nextDouble() > 0.1) {
//              Generating noise
                val error = if (Random.nextDouble() > 0.9) {
                    Random.nextDouble(0.0, 0.3) - 0.2
                } else {
                    0.0
                }
                sum += receivedMessage.content.toDouble() - error
            }
        }

//      Update our number
        number = (number + sum) * alpha

//      Print result if we are the first node
        if ((state == nodesNum) and (name.toString() == "0")) println("$number")
        state++
    }

    override fun done(): Boolean {
        return state == nodesNum + 1
    }

}
