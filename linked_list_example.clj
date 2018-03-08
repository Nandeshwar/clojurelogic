(ns clojurelogic.linked-list-example)

(declare add)
(declare display)
(declare insert-item)

(defprotocol INode
  (getId [this])
  (getNext [this])
  (setNext [this y])
  (display1 [this x]))

(deftype Node [id ^:volatile-mutable next]
  INode
  (getId [this] id)
  (getNext [this] next)
  (setNext [this nw-node] (set! next nw-node) next)

  ; This method is equivalent to display method given below
  ; I was just testing to have this interface
  (display1 [this node]
            (if (nil? (.getNext node))
              (do
                (println (.getId node))
                nil)
              (do
                (println (.getId node))
                (recur (.getNext node))))))

(def start nil)
(def current nil)
(def is-first-item true)

(defn linked-list []
  (println "Linked list demonstration")
  (add 10)
  (add 20)
  (add 30)

  (insert-item 30 200)
  (display start)
  (println "------------Display again------")
  ; display1 is method
  ; start 2nd parameter:  is object on which display1 is getting called
  ; 3rd parameter : passint object
  (.display1 start start))


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

(defn- insert-item [after item]
  (loop [current start]
    (if (nil? (.getNext current))
      (do
        (if (= (.getId current) after)
          (do
            (.setNext current (Node. item nil))
            true)
          false))
      (do
        (if (= (.getId current) after)
          (do
            (def new-node (Node. item (.getNext current)))
            (def tmp (getNext current))
            (.setNext current new-node)
            (.setNext new-node tmp)
            true)
          (recur (.getNext current)))))))

