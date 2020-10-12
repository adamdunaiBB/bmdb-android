#!/bin/bash
# fail if any commands fails
set -e
# debug log
set -x

PATTERN=".+${CHECK_JIRA_TICKET_SCRIPT_ID}\-[0-9]+"
COMMIT_WITH_MISSING_TICKET_ID_EXISTS=false
COMMITS_WITH_MISSING_TICKET_ID=""

git fetch --all
git checkout $BITRISE_GIT_BRANCH

echo "Checking if commits contain JIRA ticket ID..."
for COMMIT_HASH in $(git cherry origin/$BITRISEIO_GIT_BRANCH_DEST $BITRISE_GIT_BRANCH)
do
	if [[ $COMMIT_HASH != "+" && $COMMIT_HASH != "-" ]]; then
		BODY=$(git log -n 1 --pretty=format:%B $COMMIT_HASH)
		if [[ ! $BODY =~ $PATTERN ]]; then
			COMMIT_WITH_MISSING_TICKET_ID_EXISTS=true
			COMMITS_WITH_MISSING_TICKET_ID+="- $(git log -n 1 --pretty=oneline $COMMIT_HASH)<br/>"
		fi
	fi
done

if [[ "$COMMIT_WITH_MISSING_TICKET_ID_EXISTS" = true ]]; then
	RESULT=":x: &nbsp;Fail! The following commit(s) does not contain JIRA ticket ID:<br/><br/>${COMMITS_WITH_MISSING_TICKET_ID}"
	echo $RESULT | envman add --key CHECK_JIRA_TICKET_SCRIPT_RESULT
	exit 1
fi

echo ":white_check_mark: &nbsp;All commit messages contain JIRA ticket ID :partying_face:" | envman add --key CHECK_JIRA_TICKET_SCRIPT_RESULT
exit 0