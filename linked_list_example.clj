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



(def start (ref nil))
(def begin (ref start)) ; getting used in display
(def current (ref nil))
(def is-first-item true)


(defn update-start [node]
  (dosync
   (ref-set start node)))

(defn update-current [node]
  (dosync
   (ref-set current node)))

(defn update-begin [node]
  (dosync
   (ref-set begin node)))

(defn linked-list []
  (println "Linked list demonstration")
  (add 10)
  (println start)
  (println (.getId (deref current)))
  (add 20)
  (println (.getId (deref current)))
  (add 30)

  (println (.getId (deref begin)))
  (println (.getId (.getNext (deref start))))
  (println "____________")
  (display)
;  (println (.getId (.getNext begin)))
  )


(defn- add [item]
  (if (true? is-first-item)
    (do

      (update-start (Node. item nil ))
      ;(println (.getId (deref start)))
      (update-current (deref start))
      (update-begin @current)
      (def is-first-item false))
    (do
      (.setNext (deref current) (Node. item nil ))
      (update-current (.getNext (deref current))))))

(defn- display []

  (if (= (.getNext (deref begin)) nil)
    nil
    (do
      (println (.getId (deref begin)))
      (update-begin (.getNext (deref begin)))
      (recur)))
  )