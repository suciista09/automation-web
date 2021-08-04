# Introduction

This projects contain 2 test, checkout and sort product list by lowest price. Note: expect an error while running sorting test because the system also throw an error. Only available on chrome testing.<br>
Spec to run
- Java min 8
- chrome latest version installed

## How to run <br>
- `./gradlew --continue clean cucumber --tags "@checkout or @sort" generateCucumberReports`
- Run checkout / sorting only 
    `./gradlew --continue clean cucumber --tags "@checkout" generateCucumberReports`
    `./gradlew --continue clean cucumber --tags "@sort" generateCucumberReports`
