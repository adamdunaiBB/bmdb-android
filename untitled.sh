#!/bin/bash
# fail if any commands fails
set -e
# debug log
set -x

PATTERN='.+SBWSS\-[0-9]+'

git fetch --all
git checkout $BITRISE_GIT_BRANCH

echo "Checking if commits contain JIRA ticket ID..."
for COMMITS in $(git cherry origin/$BITRISEIO_GIT_BRANCH_DEST $BITRISE_GIT_BRANCH)
do
	if [[ $COMMITS != "+" && $COMMITS != "-" ]]; then
		BODY=$(git log -n 1 --pretty=format:%B $COMMITS)
		if [[ ! $BODY =~ $PATTERN ]]; then
			echo ":x: &nbsp;Fail! The following commit does not contains JIRA ticket ID:<br/> ${BODY}" | envman add --key COMMIT_MESSAGE_CHECK_RESULT
			exit 1
		fi
	fi
done
echo ":white_check_mark: &nbsp;All commit messages contain JIRA ticket ID :partying_face:" | envman add --key COMMIT_MESSAGE_CHECK_RESULT
exit 0