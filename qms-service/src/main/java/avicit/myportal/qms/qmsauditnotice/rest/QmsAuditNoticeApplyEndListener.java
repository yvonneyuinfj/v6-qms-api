package avicit.myportal.qms.qmsauditnotice.rest;

import avicit.platform6.api.bpm.eventInterface.CommonRestEventInterface;
import avicit.platform6.core.rest.msg.ResponseMsg;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class QmsAuditNoticeApplyEndListener implements CommonRestEventInterface {

    @Override
    public ResponseMsg<?> notify(Map<String, String> args) throws Exception {
        return null;
    }
}
