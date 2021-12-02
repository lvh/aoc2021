(ns io.lvh.aoc2021
  (:require
   [clojure.string :as str]
   [clojure.edn :as edn]
   [clojure.java.io :as io])
  (:gen-class))

(defn edn-lines
  [r]
  (->> r io/resource io/reader line-seq (map edn/read-string)))

(defn edn-vecs
  [r]
  (for [line (-> r io/resource io/reader line-seq)
        :let [parts (str/split line #" ")]]
    (mapv edn/read-string parts)))

(comment
  (edn-vecs "2-test"))
