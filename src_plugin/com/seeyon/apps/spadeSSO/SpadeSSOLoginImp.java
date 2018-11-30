package com.seeyon.apps.spadeSSO;

import com.seeyon.ctp.portal.sso.SSOLoginHandshakeAbstract;

public class SpadeSSOLoginImp extends SSOLoginHandshakeAbstract {

        // “ticket” 就是ticket取得的参数值
        @Override
        public String handshake(String ticket) {
            if(ticket==null||ticket.equals("")) {
                return null;
            }
            String userName="";
            // 这个是gke自己特定的ticket格式:{GID},{passport}
            String[] r=ticket.split(",");
            if(r==null||r.length!=2) {
                return null;
            }
            userName=this.checkPassport(r[0], r[1]);
            return userName;
        }
        @Override
        public void logoutNotify(String ticket) {

        }

        private String checkPassport(String GID,String passPort) {
            StringBuffer sb = new StringBuffer();
            sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            sb.append("<request type=\"login\" subtype=\"passport\" msid=\"\">");
            sb.append("<message>");
            sb.append("<user");
            sb.append(" GID=\"" + GID + "\"  gid=\"\"  zoneid=\"\">");
            sb.append("<passport>");
            sb.append(passPort);
            sb.append("</passport>");
            sb.append("</user>");
            sb.append("</message>");
            sb.append("</request>");
            // 向GKE发出请求，取得协同登录名
//            return getGKEResponse(postGKERequest(sb.toString()));
            return "";
        }
}
