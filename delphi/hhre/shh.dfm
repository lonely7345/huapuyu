object FrmShh: TFrmShh
  Left = 197
  Top = 117
  Caption = #20108#25163#25151#31649#29702
  ClientHeight = 582
  ClientWidth = 748
  Color = clBtnFace
  ParentFont = True
  FormStyle = fsMDIChild
  OldCreateOrder = False
  Position = poScreenCenter
  Visible = True
  WindowState = wsMaximized
  OnClose = FormClose
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel
    Left = 0
    Top = 0
    Width = 233
    Height = 582
    Align = alLeft
    BevelOuter = bvNone
    TabOrder = 0
    object btnNew: TButton
      Left = 24
      Top = 24
      Width = 75
      Height = 25
      Caption = #26032#24314
      TabOrder = 0
      OnClick = btnNewClick
    end
    object btnQuery: TButton
      Left = 128
      Top = 24
      Width = 75
      Height = 25
      Caption = #26597#35810
      TabOrder = 1
    end
  end
  object DBGrid1: TDBGrid
    Left = 233
    Top = 0
    Width = 515
    Height = 582
    Align = alClient
    TabOrder = 1
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'Tahoma'
    TitleFont.Style = []
  end
end