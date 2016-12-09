/*
* Licensed Materials - Property of IBM Corp.
* IBM UrbanCode Build
* IBM UrbanCode Deploy
* IBM UrbanCode Release
* IBM AnthillPro
* (c) Copyright IBM Corporation 2002, 2013. All Rights Reserved.
*
* U.S. Government Users Restricted Rights - Use, duplication or disclosure restricted by
* GSA ADP Schedule Contract with IBM Corp.
*/
import com.urbancode.air.plugin.wmbcmp.*;
import com.urbancode.air.plugin.*;

File workDir = new File('.');

Properties props = PropertiesHelper.getProperties(new File(args[0]));
def messageFlows = props['messageFlows'];

def helper = new IIBHelper(props)

try {
    if (messageFlows) {
        for (def messageFlow in messageFlows.split("\n|,")*.trim()) {
            println "Stopping message flow ${messageFlow}";
            helper.stopMsgFlow(messageFlow);
        }
    }
    else {
        println "Stopping all message flows!"
        helper.stopAllMsgFlows();
    }
}
catch (Exception e) {
    e.printStackTrace();
    throw e;
}
finally {
    helper.cleanUp();
}