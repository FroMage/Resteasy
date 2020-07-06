package org.jboss.resteasy.core;

import java.util.ArrayList;

import org.jboss.resteasy.util.AbstractThreadLocalStack;

public class BodyStackThreadLocalStack extends AbstractThreadLocalStack<Object>
{
   private ThreadLocal<ArrayList<Object>> local = new ThreadLocal<ArrayList<Object>>();

   @Override
   protected ArrayList<Object> getLocal()
   {
      return local.get();
   }

   @Override
   protected void setLocal(ArrayList<Object> val)
   {
      local.set(val);
   }

}
