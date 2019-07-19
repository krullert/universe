#!/bin/bash
mkdir -p .mvn/conf/
rm -f .mvn/conf/settings.xml
cp configure-maven-settings.xml .mvn/conf/settings.xml
BINTRAY_SERVER_NAME="${BINTRAY_SERVER_NAME:=null}"
BINTRAY_USER_NAME="${BINTRAY_USER_NAME:=null}"
BINTRAY_API_KEY="${BINTRAY_API_KEY:=null}"
sed --in-place "/<servers>/ a\
\\
        <server>\n\
            <id>${BINTRAY_SERVER_NAME}</id>\n\
            <username>${BINTRAY_USER_NAME}</username>\n\
            <password>${BINTRAY_API_KEY}</password>\n\
        </server>" .mvn/conf/settings.xml

sed --in-place "/<profiles>/ a\
\\
        <profile>\n\
            <id>release</id>\n\
            <activation>\n\
                <activeByDefault>false</activeByDefault>\n\
            </activation>\n\
        </profile>" .mvn/conf/settings.xml