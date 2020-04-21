package pl.klawoj

import scala.collection.mutable

trait DummyQueue {

  import DummyQueue._

  def itemsToHandle: Int = nrOfMessages

  var queues: Map[Int, mutable.Queue[DeviceTask]] = Map.empty[Int, mutable.Queue[DeviceTask]]

  queues = insertedDeviceTasks(queues)
}

object DummyQueue {
  private val nrOfDevices = 7
  private val nrOfMessages = 100

  private def insertedDeviceTasks(map: Map[Int, mutable.Queue[DeviceTask]]): Map[Int, mutable.Queue[DeviceTask]] = {
    var filledMap = map

    Range(0, nrOfMessages)
      .map(idx => {
        val deviceId = idx % nrOfDevices
        if (!filledMap.contains(deviceId)) {
          filledMap = filledMap + ((deviceId, new mutable.Queue[DeviceTask]))
        }
        filledMap(deviceId) += (DeviceTask(idx % nrOfDevices, idx / nrOfDevices, new Object))
      })

    filledMap
  }
}
