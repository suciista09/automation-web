# Introduction

This projects contain 2 test, checkout and sort product list by lowest price. Note: expect an error while running sorting test because the system also throw an error. Only available on chrome testing.<br>
Spec to run
- Java min 8
- chrome latest version installed
<br>
  <br>
## How to run <br>
1. `./gradlew --continue clean cucumber --tags "@checkout or @sort" generateCucumberReports` <br>
2. Run checkout / sorting only <br>
`./gradlew --continue clean cucumber --tags "@checkout" generateCucumberReports`<br> OR <br>
`./gradlew --continue clean cucumber --tags "@sort" generateCucumberReports`