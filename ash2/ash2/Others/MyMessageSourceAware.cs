﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Spring.Context;

namespace ash2.others
{
    public class MyMessageSourceAware : IMessageSourceAware
    {
        public IMessageSource MessageSource
        {
            set { throw new NotImplementedException(); }
        }
    }
}