package org.unidal.web.lifecycle;

public class DefaultUrlMapping implements UrlMapping {
   private String m_contextPath;

   private String m_servletPath;

   private String m_module;

   private String m_action;

   private String m_pathInfo;

   private String m_queryString;

   public DefaultUrlMapping() {
   }

   public DefaultUrlMapping(String[] sections) {
      int index = 0;

      m_contextPath = sections[index++];
      m_servletPath = sections[index++];
      m_module = trim(sections[index++]);
      m_action = trim(sections[index++]);
      m_pathInfo = trim(sections[index++]);
      m_queryString = sections[index++];
   }

   public DefaultUrlMapping(UrlMapping urlMapping) {
      m_contextPath = urlMapping.getContextPath();
      m_servletPath = urlMapping.getServletPath();
      m_module = urlMapping.getModule();
      m_action = urlMapping.getAction();
      m_pathInfo = urlMapping.getPathInfo();
      m_queryString = urlMapping.getQueryString();
   }

   public String getAction() {
      return m_action;
   }

   public String getContextPath() {
      return m_contextPath;
   }

   public String getModule() {
      return m_module;
   }

   public String getPathInfo() {
      return m_pathInfo;
   }

   public String getQueryString() {
      return m_queryString;
   }

   public String getServletPath() {
      return m_servletPath;
   }

   public void setAction(String action) {
      m_action = action;
   }

   public void setContextPath(String contextPath) {
      m_contextPath = contextPath;
   }

   @Override
   public void setModule(String module) {
      m_module = module;
   }

   public void setPathInfo(String pathInfo) {
      m_pathInfo = pathInfo;
   }

   public void setQueryString(String queryString) {
      m_queryString = queryString;
   }

   public void setServletPath(String servletPath) {
      m_servletPath = servletPath;
   }

   @Override
   public String toString() {
      return String.format("%s[servletPath=%s, contextPath=%s, module=%s, action=%s, pathInfo=%s, queryString=%s]",
            getClass().getSimpleName(), m_servletPath, m_contextPath, m_module, m_action, m_pathInfo, m_queryString);
   }

   private String trim(String str) {
      if (str != null) {
         int pos = str.indexOf(';');

         if (pos > 0) {
            return str.substring(0, pos);
         }
      }

      return str;
   }
}
