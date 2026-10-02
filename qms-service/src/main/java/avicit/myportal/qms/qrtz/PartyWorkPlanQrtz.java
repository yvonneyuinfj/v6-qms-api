// package avicit.myportal.qms.qrtz;
//
// import avicit.myportal.plancenter.constant.PlanConstants;
// import avicit.myportal.plancenter.pcpartyworkplan.dao.PcPartyWorkPlanDAO;
// import avicit.myportal.plancenter.pcpartyworkplan.dto.PcPartyWorkPlanDTO;
// import avicit.myportal.plancenter.pcpartyworkplan.service.PcPartyWorkPlanService;
// import avicit.myportal.plancenter.pcpartyworkplanfeedback.service.PcPartyWorkPlanFeedbackService;
// import avicit.myportal.plancenter.util.MessageSendHandler;
// import avicit.myportal.plancenter.util.PortalToDoHandler;
// import avicit.platform6.commons.utils.StringUtils;
// import avicit.platform6.core.rest.msg.ResponseMsg;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.env.Environment;
// import org.springframework.web.bind.annotation.*;
//
// import java.util.*;
//
// @RestController
// @RequestMapping("/api/myportal/plancenter/qrtz")
// public class PartyWorkPlanQrtz {
//
//     private static final Logger logger = (Logger) LoggerFactory.getLogger(PartyWorkPlanQrtz.class);
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
//      * 每个季度最后一个月20号预检查工作计划反馈情况，未反馈的发送消息。
//      *
//      * @return
//      */
//     @PostMapping("/preCheckWorkPlanFeedBackStatus/v1")
//     public ResponseMsg<List<PcPartyWorkPlanDTO>> preCheckWorkPlanFeedBackStatus(@RequestBody Map<String, String> args) {
//         ResponseMsg<List<PcPartyWorkPlanDTO>> responseMsg = new ResponseMsg<>();
//         responseMsg.setResponseBody(this.test());
//         return responseMsg;
//     }
//
//     private List<PcPartyWorkPlanDTO> test() { // 集团党组一号文
//         //    1. 获取需要检查的工作计划列表
//         //    WORK_STATUS = '1' 正在进行 且 PlanDeadline 计划完成时间 晚于 当前时间 的工作计划
//         PcPartyWorkPlanDTO dto = new PcPartyWorkPlanDTO();
//         // dto.setWorkStatus(PlanConstants.PLAN_IN_PROGRESS); // 正在进行
//         dto.setTreeLeaf("Y");
//         dto.setMainPlanTypeCode("JTDZYHW");
//         // dto.setResponsibilityUserCodes("u4891");
//         List<PcPartyWorkPlanDTO> dtos = pcPartyWorkPlanDAO.searchPcPartyWorkPlan(dto);
//         List<PcPartyWorkPlanDTO> newDtos = new ArrayList<>();
//         for (PcPartyWorkPlanDTO pdto : dtos) {
//             //  如果已完成，不提醒
//             if(pdto.getWorkStatus().equals(PlanConstants.PLAN_COMPLETED)){
//                 continue;
//             }
//             // 如果已过截止日期，不提醒。
//             // if (pdto.getPlanDeadline().before(new Date())) {
//             //     continue;
//             // }
//             // 没有反馈状态，直接提醒
//             if (StringUtils.isEmpty(pdto.getFeedbackStatus()) || pdto.getFeedbackStatus().equals("0")) {
//                 newDtos.add(pdto);
//                 continue;
//             }
//             // 如果反馈状态为【办结反馈流转中】或【办结反馈已完成】的，不提醒。
//             if (pdto.getFeedbackStatus().equals("55") || pdto.getFeedbackStatus().equals("59")) {
//                 continue;
//             }
//             // 获取当前月份
//             Calendar calendar = Calendar.getInstance();
//             int month = calendar.get(Calendar.MONTH) + 1;
//             Map<Integer, String> map = new HashMap<>();
//             map.put(3, "1");
//             map.put(6, "2");
//             map.put(9, "3");
//             map.put(12, "4");
//
//             if (StringUtils.isEmpty(pdto.getFeedbackStatus()) || (month % 3 == 0 && Integer.parseInt(pdto.getFeedbackStatus()) < Integer.parseInt(map.get(month) + "5"))) {
//                 newDtos.add(pdto);
//             }
//
//         }
//         for (PcPartyWorkPlanDTO nDto : newDtos) {
//             // 向责任人 发送消息提醒
//             String[] userIds = nDto.getResponsibilityUserIds().split(";");
//             String responsibilityLeaderIds = nDto.getResponsibilityLeaderIds();
//             String[] leaderIds = {};
//             if (StringUtils.isNotEmpty(responsibilityLeaderIds)) {
//                 leaderIds = responsibilityLeaderIds.split(";");
//             }
//
//             StringBuilder sb = new StringBuilder();
//             sb.append("您主责的以下1号文工作计划尚未完成本季度反馈，请按时反馈。").append("【").append(nDto.getPlanContent()).append("】");
//             for (String userId : userIds) {
//                 // 发送消息
//                 messageSendHandler.sendJsonMsg("党组1号文工作计划反馈提醒", sb.toString(), environment.getProperty("aeccit.partyPlanRedirect.msgUrl", "/myportal/plancenter/pcpartyworkplan/"), null, userId);
//                 // 组装数据
//                 Map<String, String> params = new HashMap<>();
//                 params.put("psCode", "pc");
//                 params.put("dbid", nDto.getId());
//                 params.put("pTitle", nDto.getPlanContent());
//                 params.put("pPortalUser", userId);
//                 params.put("planTypeId", nDto.getPlanTypeId());
//                 portalToDoHandler.insertTodo(params); // 向门户发送待办
//             }
//             // for (String userId : leaderIds) {
//             //     messageSendHandler.sendJsonMsg("党组1号文工作计划反馈提醒", sb.toString(), environment.getProperty("aeccit.partyPlanRedirect.msgUrl", "/myportal/plancenter/pcpartyworkplan/"), null, userId);
//             //     // 组装数据
//             //     Map<String, String> params = new HashMap<>();
//             //     params.put("psCode", "pc");
//             //     params.put("dbid", nDto.getId());
//             //     params.put("pTitle", nDto.getPlanContent());
//             //     params.put("pPortalUser", userId);
//             //     params.put("planTypeId", nDto.getPlanTypeId());
//             //     portalToDoHandler.insertTodo(params); // 向门户发送待办
//             // }
//         }
//         return newDtos;
//     }
//
// }
