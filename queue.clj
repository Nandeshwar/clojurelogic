(ns clojurelogic.queue)

(declare enqueue)
(declare dequeue)

(def queue-list [])
(def queue-list-size 3)

(defn queue-example []
  (println "Queexample")
  (enqueue 10)
  (enqueue 20)
  (enqueue 30)
  (enqueue 40)

  (dequeue)
  (dequeue)
  (dequeue)
  (dequeue))

(defn- enqueue [item]
  (if (= (count queue-list)
         queue-list-size)
    (println "Queue is full")
    (do
      (def queue-list (conj queue-list item))
      (println "item " item "Added successfully")
      (println queue-list))))

(defn- dequeue []
  (if (zero? (count queue-list))
    (println "Queue is empty")
    (do
      (let [item (nth queue-list 0)]
        (println item "Dequeued successfully"))
      (def queue-list (subvec queue-list 1))
      (println queue-list))))