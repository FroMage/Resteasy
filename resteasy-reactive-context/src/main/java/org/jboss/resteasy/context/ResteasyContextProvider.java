package org.jboss.resteasy.context;

import java.util.Collections;
import java.util.Map;

import org.eclipse.microprofile.context.spi.ThreadContextSnapshot;
import org.jboss.resteasy.core.ResteasyContext;
import org.jboss.resteasy.util.ContextualStackStorageDeclaration;

import io.smallrye.context.FastStorageThreadContextProvider;

public class ResteasyContextProvider implements FastStorageThreadContextProvider<ContextualStackStorageDeclaration>
{

   private static final String JAXRS_CONTEXT = "JAX-RS";

   @Override
   public ThreadContextSnapshot currentContext(Map<String, String> props)
   {
      Map<Class<?>, Object> context = ResteasyContext.getContextDataMap();
      return () -> {
         ResteasyContext.pushContextDataMap(context);
         return () -> {
            ResteasyContext.removeContextDataLevel();
         };
      };
   }

   @Override
   public ThreadContextSnapshot clearedContext(Map<String, String> props)
   {
      Map<Class<?>, Object> context = Collections.emptyMap();
      return () -> {
         ResteasyContext.pushContextDataMap(context);
         return () -> {
            ResteasyContext.removeContextDataLevel();
         };
      };
   }

   @Override
   public String getThreadContextType()
   {
      return JAXRS_CONTEXT;
   }

   @Override
   public Class<ContextualStackStorageDeclaration> getStorageDeclaration()
   {
      return ContextualStackStorageDeclaration.class;
   }
}
