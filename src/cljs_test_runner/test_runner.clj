(ns cljs-test-runner.test-runner
  (:require [cljs-test-runner.main]
            [clojure.java.io :as io]))

(defmacro run-tests [options]
  (cljs-test-runner.main/with-dynamic-classloader
    (cljs-test-runner.main/test-cljs-namespaces-in-dir
      (merge {:out (str "cljs-test-runner-out" #_(System/currentTimeMillis))
              :dir #{"test"}
              :env :node                                    ; todo remove
              :in-repl? true}
        options)))
  `(require 'cljs-test-runner.gen :reload))
