package pl.klawoj

import java.util.concurrent.ConcurrentHashMap

import scala.collection.mutable

trait TaskQueue {
  var queues: Map[Int, mutable.Queue[DeviceTask]]
}
