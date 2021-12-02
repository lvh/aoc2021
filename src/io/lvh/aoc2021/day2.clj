(ns io.lvh.aoc2021.day2
  (:require
   [io.lvh.aoc2021 :refer [edn-vecs]]))

(def start-pos {:depth 0 :horiz 0 :aim 0})

(defn move
  [pos [direction distance]]
  (let [[coord sign] (case direction
                       forward [:horiz +]
                       down [:depth +]
                       up [:depth -])]
    (update pos coord sign distance)))

(defn move2
  [{:keys [aim] :as pos} [direction distance]]
  (if (= direction 'forward)
    (-> pos
        (update :horiz + distance)
        (update :depth + (* aim distance)))
    (let [sign (if (= direction 'down) + -)]
      (update pos :aim sign distance))))

(defn answer
  [move instructions]
  (let [{:keys [depth horiz]} (reduce move start-pos instructions)]
    (* depth horiz)))

(def answer-one (partial answer move))
(def answer-two (partial answer move2))

(comment
  (answer-one (edn-vecs "2-test"))
  (answer-one (edn-vecs "2"))

  (answer-two (edn-vecs "2-test"))
  (answer-two (edn-vecs "2")))
