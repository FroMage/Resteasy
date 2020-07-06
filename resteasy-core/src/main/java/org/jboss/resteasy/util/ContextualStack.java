package org.jboss.resteasy.util;

import java.util.ArrayList;
import java.util.Map;

import io.smallrye.context.storage.spi.StorageManager;

public class ContextualStack extends AbstractThreadLocalStack<Map<Class<?>, Object>>
{
   private ThreadLocal<ArrayList<Map<Class<?>, Object>>> local = StorageManager.threadLocal(ContextualStackStorageDeclaration.class);

   @Override
   protected ArrayList<Map<Class<?>, Object>> getLocal()
   {
      return local.get();
   }

   @Override
   protected void setLocal(ArrayList<Map<Class<?>, Object>> val)
   {
      local.set(val);
   }
}
