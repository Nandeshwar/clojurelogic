(ns clojurelogic.linked-list-example)

(declare add)
(declare display)

(definterface INode
  (getId [])
  (getNext [])
  (setId [x])
  (setNext [x]))

(deftype Node [id ^:volatile-mutable next]
  INode
  (getId [this] id)
  (getNext [this] next)
  (setNext [this x] (set! next x) this))

(def start nil)
(def begin nil)
(def current nil)
(def is-first-item true)

(defn linked-list []
  (println "Linked list demonstration")
  (add 10)
  (add 20)
  (add 30)

  (display))

(defn- add [item]
  (if (true? is-first-item)
    (do
      (def start (Node. item nil ))
      (def current start)
      (def begin start)
      (def is-first-item false))
    (do
      (.setNext current (Node. item nil ))
      (def current (.getNext current)))))

(defn- display []
  (if (nil? (.getNext begin))
    (do
      (println (.getId begin))
      nil)
    (do
      (println (.getId begin))
      (def begin (.getNext begin))
      (recur))))
