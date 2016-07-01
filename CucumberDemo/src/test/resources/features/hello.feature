#language: zh-CN
#"zh-CN": {
#    "but": "*|但是<",
#    "and": "*|而且<|并且<|同时<",
#    "then": "*|那么<",
#    "when": "*|当<",
#    "name": "Chinese simplified",
#    "native": "简体中文",
#    "feature": "功能",
#    "background": "背景",
#    "scenario": "场景|剧本",
#    "scenario_outline": "场景大纲|剧本大纲",
#    "examples": "例子",
#    "given": "*|假如<|假设<|假定<"
#  },
功能: 验证加法器

  场景大纲: 正数相加
    假设 有一个正数<a>
    当 加上一个正数<b>
    那么 得到一个正数<c>

    例子:
      | a | b | c |
      | 1 | 2 | 3 |
      | 3 | 6 | 9 |


