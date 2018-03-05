(ns clojurelogic.stack)

(declare push)
(declare pop)

(def my-list [])
(def list-size 3)
(def counter 0)

(defn stack-example []
  (println "I am here")
  (push 10)
  (println my-list)
  (push 20)
  (println my-list)
  (push 30)
  (println my-list)
  (push 40)
  (println my-list)
  (pop)
  (println my-list)
  (pop)
  (println my-list)
  (pop)
  (println my-list)
  (pop)
  (println my-list))

(defn- push [num]
  (if (= (count my-list) list-size)
    (println "Stack is full")
    (do
      (def my-list (conj my-list num))
      (def counter (inc counter)))))

(defn- pop []
  (if (zero? counter)
    (println "Stack is empty")
    (let [ind-last-item (.indexOf my-list (last my-list))]
      (def my-list (subvec my-list 0 ind-last-item))
      (def counter (dec counter)))))

