# Aspectj-snipped
This repository contains snipped for aspectj

# 1. Aspectj installation

Download from http://www.eclipse.org/aspectj/downloads.php and run for install

``
cd <installation-path>
`` 
``
java -jar <path-to-downloaded-file>
``

# 2. Enabling Load-time Weaving
Configure eclipse variable ASPECTJ_HOME to be used as VM Argument

	Run >> Run Configurations ... >> Java Application >> Arguments >> VM Arguments >> Variables ... >> Edit variables ... >> New ...
| Variable	   | Value					 |
| ------------ | ----------------------- |
| ASPECTJ_HOME | ``<installation-path>`` |

Add to VM Arguments:
``-javaagent:${ASPECT_HOME}/lib/aspectjweaver.jar``
