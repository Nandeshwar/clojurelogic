(ns clojurelogic.linked-list-example)

(declare add)
(declare display)

;(deftype Node [id ^:volatile-mutable next])

(definterface INode
  (getId [])
  (getNext [])
  (setId [x])
  (setNext [x]))

(deftype Node [^:volatile-mutable id ^:volatile-mutable next]
  INode
  (getId [this] id)
  (getNext [this] next)
  (setId [this x] (set! id x) this)
  (setNext [this x] (set! next x) this))



(def start nil)
(def begin start) ; getting used in display
(def current nil)
(def is-first-item true)

(defn linked-list []
  (println "Linked list demonstration")
  (add 10)
  (println start)
  (println (.getId current))
  (add 20)
  (println (.getId current))
;  (display)
  (println "____________")
;  (println (.getId (.getNext begin)))
  )


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

  (if (= (.getNext begin) nil)
    nil
    (do
      (println (.getId begin))
      (def begin (.getNext begin))
      (recur)))
  )