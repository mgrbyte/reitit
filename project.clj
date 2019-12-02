(defproject metosin/reitit-parent "0.3.10"
  :description "Snappy data-driven router for Clojure(Script)"
  :url "https://github.com/metosin/reitit"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :test-paths ["test/clj" "test/cljc"]
  :deploy-repositories [["releases" :clojars]]
  :codox {:output-path "doc"
          :source-uri "https://github.com/metosin/reitit/{version}/{filepath}#L{line}"
          :metadata {:doc/format :markdown}}
  :scm {:name "git"
        :url "https://github.com/metosin/reitit"}
  ;; TODO: need to verify that the code actually worked with Java1.8, see #242
  :javac-options ["-Xlint:unchecked" "-target" "1.8" "-source" "1.8"]
  :managed-dependencies [[metosin/reitit "0.3.10"]
                         [metosin/reitit-core "0.3.10"]
                         [metosin/reitit-dev "0.3.10"]
                         [metosin/reitit-spec "0.3.10"]
                         [metosin/reitit-malli "0.3.10"]
                         [metosin/reitit-schema "0.3.10"]
                         [metosin/reitit-ring "0.3.10"]
                         [metosin/reitit-middleware "0.3.10"]
                         [metosin/reitit-http "0.3.10"]
                         [metosin/reitit-interceptors "0.3.10"]
                         [metosin/reitit-swagger "0.3.10"]
                         [metosin/reitit-swagger-ui "0.3.10"]
                         [metosin/reitit-frontend "0.3.10"]
                         [metosin/reitit-sieppari "0.3.10"]
                         [metosin/reitit-pedestal "0.3.10"]
                         [metosin/ring-swagger-ui "2.2.10"]
                         [metosin/spec-tools "0.10.0"]
                         [metosin/schema-tools "0.12.0"]
                         [metosin/muuntaja "0.6.5"]
                         [metosin/jsonista "0.2.5"]
                         [metosin/sieppari "0.0.0-alpha7"]
                         [metosin/malli "0.0.1-SNAPSHOT"]

                         [meta-merge "1.0.0"]
                         [fipp "0.6.21" :exclusions [org.clojure/core.rrb-vector]]
                         [expound "0.7.2"]
                         [lambdaisland/deep-diff "0.0-47"]
                         [com.bhauman/spell-spec "0.1.1"]
                         [ring/ring-core "1.7.1"]

                         [io.pedestal/pedestal.service "0.5.7"]]

  :plugins [[jonase/eastwood "0.3.6"]
            ;[lein-virgil "0.1.7"]
            [lein-doo "0.1.11"]
            [lein-cljsbuild "1.1.7"]
            [lein-cloverage "1.1.2"]
            [lein-codox "0.10.7"]
            [metosin/bat-test "0.4.3"]]

  :profiles {:dev {:jvm-opts ^:replace ["-server"]

                   ;; all module sources for development
                   :source-paths ["modules/reitit/src"
                                  "modules/reitit-core/src"
                                  "modules/reitit-dev/src"
                                  "modules/reitit-ring/src"
                                  "modules/reitit-http/src"
                                  "modules/reitit-middleware/src"
                                  "modules/reitit-interceptors/src"
                                  "modules/reitit-malli/src"
                                  "modules/reitit-spec/src"
                                  "modules/reitit-schema/src"
                                  "modules/reitit-swagger/src"
                                  "modules/reitit-swagger-ui/src"
                                  "modules/reitit-frontend/src"
                                  "modules/reitit-sieppari/src"
                                  "modules/reitit-pedestal/src"]

                   :java-source-paths ["modules/reitit-core/java-src"]

                   :dependencies [[org.clojure/clojure "1.10.1"]
                                  [org.clojure/clojurescript "1.10.520"]

                                  ;; modules dependencies
                                  [metosin/schema-tools]
                                  [metosin/spec-tools]
                                  [metosin/muuntaja]
                                  [metosin/sieppari]
                                  [metosin/jsonista]
                                  [metosin/malli]
                                  [lambdaisland/deep-diff]
                                  [meta-merge]
                                  [com.bhauman/spell-spec]
                                  [expound]
                                  [fipp]

                                  [orchestra "2019.02.06-1"]

                                  [ring "1.7.1"]
                                  [ikitommi/immutant-web "3.0.0-alpha1"]
                                  [metosin/ring-swagger-ui "2.2.10"]

                                  [criterium "0.4.5"]
                                  [org.clojure/test.check "0.10.0"]
                                  [org.clojure/tools.namespace "0.3.1"]
                                  [com.gfredericks/test.chuck "0.2.10"]

                                  [io.pedestal/pedestal.service "0.5.7"]

                                  [org.clojure/core.async "0.4.500"]
                                  [manifold "0.1.8"]
                                  [funcool/promesa "4.0.2"]

                                  [com.clojure-goes-fast/clj-async-profiler "0.4.0"]
                                  [ring-cors "0.1.13"]

                                  [com.bhauman/rebel-readline "0.1.4"]]}
             :1.9 {:dependencies [[org.clojure/clojure "1.9.0"]]}
             :perf {:jvm-opts ^:replace ["-server"
                                         "-Xmx4096m"
                                         "-Dclojure.compiler.direct-linking=true"]
                    :test-paths ["perf-test/clj"]
                    :dependencies [[compojure "1.6.1"]
                                   [ring/ring-defaults "0.3.2"]
                                   [ikitommi/immutant-web "3.0.0-alpha1"]
                                   [io.pedestal/pedestal.service "0.5.7"]
                                   [io.pedestal/pedestal.jetty "0.5.7"]
                                   [calfpath "0.7.2"]
                                   [org.clojure/core.async "0.4.500"]
                                   [manifold "0.1.8"]
                                   [funcool/promesa "4.0.2"]
                                   [metosin/sieppari]
                                   [yada "1.2.16"]
                                   [aleph "0.4.6"]
                                   [ring/ring-defaults "0.3.2"]
                                   [ataraxy "0.4.2"]
                                   [bidi "2.1.6"]]}
             :analyze {:jvm-opts ^:replace ["-server"
                                            "-Dclojure.compiler.direct-linking=true"
                                            "-XX:+PrintCompilation"
                                            "-XX:+UnlockDiagnosticVMOptions"
                                            "-XX:+PrintInlining"]}}
  :aliases {"all" ["with-profile" "dev,default:dev,default,1.9"]
            "perf" ["with-profile" "default,dev,perf"]
            "test-clj" ["all" "do" ["bat-test"] ["check"]]
            "test-browser" ["doo" "chrome-headless" "test"]
            "test-advanced" ["doo" "chrome-headless" "advanced-test"]
            "test-node" ["doo" "node" "node-test"]}

  :bat-test {:report [:pretty
                      {:type :junit
                       :output-to "target/results/reitit/junit.xml"}]}

  :doo {:paths {:karma "./node_modules/.bin/karma"}
        :karma {:config {"plugins" ["karma-junit-reporter"]
                         "reporters" ["progress", "junit"]
                         "junitReporter" {"outputDir" "target/results/cljs"}}}}

  :cljsbuild {:builds [{:id "test"
                        :source-paths ["src" "test/cljc" "test/cljs"]
                        :compiler {:output-to "target/out/test.js"
                                   :output-dir "target/out"
                                   :main reitit.doo-runner
                                   :optimizations :none}}
                       {:id "advanced-test"
                        :source-paths ["src" "test/cljc" "test/cljs"]
                        :compiler {:output-to "target/advanced_out/test.js"
                                   :output-dir "target/advanced_out"
                                   :main reitit.doo-runner
                                   :optimizations :advanced}}
                       ;; Node.js requires :target :nodejs, hence the separate
                       ;; build configuration.
                       {:id "node-test"
                        :source-paths ["src" "test/cljc" "test/cljs"]
                        :compiler {:output-to "target/node_out/test.js"
                                   :output-dir "target/node_out"
                                   :main reitit.doo-runner
                                   :optimizations :none
                                   :target :nodejs}}]})
