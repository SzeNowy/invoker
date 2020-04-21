package pl.klawoj

trait Invoker extends TaskQueue with ExpensiveService {

  def delegateTasks(): Unit = {
    queues
      .par
      .foreach(device => {
        while (device._2.nonEmpty) { // while to preserve order
          val deq = device._2.dequeue();
          handleMessage(deq)
        }
      })
  }

}
