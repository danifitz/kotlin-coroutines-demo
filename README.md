# Demo app for Kotlin co-routines instrumentation

This is a demo app for [Kotlin Coroutines Instrumentation](https://github.com/newrelic-experimental/newrelic-java-kotlin-coroutines).

## Usage

1. Clone the repo to your machine `git clone https://github.com/danifitz/kotlin-coroutines-demo.git`
2. Download the [New Relic Java agent](http://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic-java.zip)
3. Unzip the Java agent to a location on your machine
4. [Download the Kotlin Coroutines instrumentation .jar file](https://github.com/newrelic-experimental/newrelic-java-kotlin-coroutines/releases/tag/1.2) and add it to the agent extensions directory
4. Edit `build.gradle` and configure `gretty.jvmArgs` to point to newrelic.jar in the location where you downloaded the agent.
5. Configure `newrelic.yml` in the agent directory with your appName and licenseKey
6. Run the kotlin demo app `./gradlew appRun`
7. In a new terminal window, run some tests against the app `./test.sh` - you might need to make this executable first by running `chmod +x test.sh`
8. Open New Relic and take a look at the demo app reporting transactions and breakdowns.

## Example Results

Transactions list
![Transactions List](https://github.com/danifitz/kotlin-coroutines-demo/raw/main/imgs/coroutine-transactions.png "Transactions List")

![Transaction Trace](https://github.com/danifitz/kotlin-coroutines-demo/raw/main/imgs/coroutine-transaction-trace.png "Transactions Trace")

![Segment Breakdown](https://github.com/danifitz/kotlin-coroutines-demo/raw/main/imgs/coroutine-segment-breakdown.png "Segment Breakdown")