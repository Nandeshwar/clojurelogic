(ns clojurelogic.linked-list-example)

(declare add)
(declare display)

(defprotocol INode
  (getId [this])
  (getNext [this])
  (setNext [this y]))

(deftype Node [id ^:volatile-mutable next]
  INode
  (getId [this] id)
  (getNext [this] next)
  (setNext [this y] (set! next y) y))



(def start nil)
(def current nil)
(def is-first-item true)

(defn linked-list []
  (println "Linked list demonstration")
  (add 10)
  (add 20)
  (add 30)

  (display start))

(defn- add [item]
  (if (true? is-first-item)
    (do
      (def start (Node. item nil ))
      (def current start)
      (def is-first-item false))
    (do
      (.setNext current (Node. item nil ))
      (def current (.getNext current)))))

(defn- display [begin]
  (if (nil? (.getNext begin))
    (do
      (println (.getId begin))
      nil)
    (do
      (println (.getId begin))
      (recur (.getNext begin)))))
