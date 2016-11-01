call gradle clean build jacocoTestReport runrobot
explorer "file:///%~dp0build/reports/tests/test/index.html"
explorer "file:///%~dp0build/reports/jacoco/test/html/index.html"
explorer "file:///%~dp0build/robot-results/report.html"