// package avicit.myportal.qms.qrtz;
//
// import avicit.platform6.core.rest.msg.ResponseMsg;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.env.Environment;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// import java.io.IOException;
// import java.util.*;
//
// @RestController
// @RequestMapping("/api/myportal/qms/qrtz")
// public class WorkPlanQrtz {
//
//     private static final Logger logger = (Logger) LoggerFactory.getLogger(WorkPlanQrtz.class);
//
//     @Autowired
//     PcPartyWorkPlanService pcPartyWorkPlanService;
//
//     @Autowired
//     PcPartyWorkPlanDAO pcPartyWorkPlanDAO;
//
//     @Autowired
//     PcPartyWorkPlanFeedbackService pcPartyWorkPlanFeedbackService;
//
//     @Autowired
//     MessageSendHandler messageSendHandler;
//
//     @Autowired
//     Environment environment;
//
//     @Autowired
//     PortalToDoHandler portalToDoHandler;
//
//
//     /**
//      * 刷新计划状态 - 机关计划 计划状态 未开展 改为 正在开展
//      *
//      * @return
//      */
//     @PostMapping("/updatePlanStatus/v1")
//     public ResponseMsg<String> updatePlanStatus(@RequestBody Map<String, String> args) {
//         ResponseMsg<String> responseMsg = new ResponseMsg<>();
//         pcPartyWorkPlanService.updatePlanStatus();
//         return responseMsg;
//     }
//
//     /**
//      * 刷新计划状态：集团党组一号文 计划状态 自动修改为 10 已超期
//      * 2025/5/20
//      *
//      * @return
//      */
//     @PostMapping("/updatePlanStatusToDelay/v1")
//     public ResponseMsg<String> updatePlanStatusToDelay(@RequestBody Map<String, String> args) {
//         ResponseMsg<String> responseMsg = new ResponseMsg<>();
//         pcPartyWorkPlanService.updatePlanStatusToDelay();
//         return responseMsg;
//     }
//
//     /**
//      * 检查计划到期时间，小于10天的，未反馈的发送消息提醒。
//      *
//      * @return
//      */
//     @PostMapping("/alertPlanToFeedBack/v1")
//     public ResponseMsg<List<PcPartyWorkPlanDTO>> alertPlanToFeedBack(@RequestBody Map<String, String> args) throws IOException {
//         ResponseMsg<List<PcPartyWorkPlanDTO>> responseMsg = new ResponseMsg<>();
//         List<PcPartyWorkPlanDTO> pcPartyWorkPlanDTOS = pcPartyWorkPlanService.alertPlanToFeedBack();
//         responseMsg.setResponseBody(pcPartyWorkPlanDTOS);
//         // ExcelUtil.exportExcel(response, pcPartyWorkPlanDTOS, PcPartyWorkPlanDTO.class,"导出数据", "sheet1" );
//         return responseMsg;
//     }
// }
