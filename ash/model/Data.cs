﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace model
{
    public class Data
    {
        public virtual Int32 id { set; get; }
        public virtual String name { set; get; }
        public virtual Byte type { set; get; }
        public virtual Boolean enable { set; get; }
    }
}