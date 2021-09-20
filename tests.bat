echo "##teamcity[testStarted name='MyTest1.test1']"
echo "##teamcity[testFinished name='MyTest1.test1']"

echo "##teamcity[testStarted name='MyTest1.test2']"
echo "##teamcity[testFailed name='MyTest1.test2' message='failure message' details='message and stack trace']"
echo "##teamcity[testFinished name='MyTest1.test2']"
